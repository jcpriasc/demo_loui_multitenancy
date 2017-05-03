package com.vortexbird.demo.presentation.backingBeans;

import com.vortexbird.demo.exceptions.*;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.dto.UsuariosDTO;
import com.vortexbird.demo.presentation.businessDelegate.*;
import com.vortexbird.demo.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class UsuariosView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuariosView.class);
    private InputText txtTusuCodigo;
    private InputText txtUsuClave;
    private InputText txtUsuLogin;
    private InputText txtUsuNombre;
    private InputText txtUsuCedula;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<UsuariosDTO> data;
    private UsuariosDTO selectedUsuarios;
    private Usuarios entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public UsuariosView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            UsuariosDTO usuariosDTO = (UsuariosDTO) e.getObject();

            if (txtTusuCodigo == null) {
                txtTusuCodigo = new InputText();
            }

            txtTusuCodigo.setValue(usuariosDTO.getTusuCodigo());

            if (txtUsuClave == null) {
                txtUsuClave = new InputText();
            }

            txtUsuClave.setValue(usuariosDTO.getUsuClave());

            if (txtUsuLogin == null) {
                txtUsuLogin = new InputText();
            }

            txtUsuLogin.setValue(usuariosDTO.getUsuLogin());

            if (txtUsuNombre == null) {
                txtUsuNombre = new InputText();
            }

            txtUsuNombre.setValue(usuariosDTO.getUsuNombre());

            if (txtUsuCedula == null) {
                txtUsuCedula = new InputText();
            }

            txtUsuCedula.setValue(usuariosDTO.getUsuCedula());

            Long usuCedula = FacesUtils.checkLong(txtUsuCedula);
            entity = businessDelegatorView.getUsuarios(usuCedula);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedUsuarios = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedUsuarios = null;

        if (txtTusuCodigo != null) {
            txtTusuCodigo.setValue(null);
            txtTusuCodigo.setDisabled(true);
        }

        if (txtUsuClave != null) {
            txtUsuClave.setValue(null);
            txtUsuClave.setDisabled(true);
        }

        if (txtUsuLogin != null) {
            txtUsuLogin.setValue(null);
            txtUsuLogin.setDisabled(true);
        }

        if (txtUsuNombre != null) {
            txtUsuNombre.setValue(null);
            txtUsuNombre.setDisabled(true);
        }

        if (txtUsuCedula != null) {
            txtUsuCedula.setValue(null);
            txtUsuCedula.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Long usuCedula = FacesUtils.checkLong(txtUsuCedula);
            entity = (usuCedula != null)
                ? businessDelegatorView.getUsuarios(usuCedula) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtTusuCodigo.setDisabled(false);
            txtUsuClave.setDisabled(false);
            txtUsuLogin.setDisabled(false);
            txtUsuNombre.setDisabled(false);
            txtUsuCedula.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtTusuCodigo.setValue(entity.getTusuCodigo());
            txtTusuCodigo.setDisabled(false);
            txtUsuClave.setValue(entity.getUsuClave());
            txtUsuClave.setDisabled(false);
            txtUsuLogin.setValue(entity.getUsuLogin());
            txtUsuLogin.setDisabled(false);
            txtUsuNombre.setValue(entity.getUsuNombre());
            txtUsuNombre.setDisabled(false);
            txtUsuCedula.setValue(entity.getUsuCedula());
            txtUsuCedula.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedUsuarios = (UsuariosDTO) (evt.getComponent().getAttributes()
                                             .get("selectedUsuarios"));
        txtTusuCodigo.setValue(selectedUsuarios.getTusuCodigo());
        txtTusuCodigo.setDisabled(false);
        txtUsuClave.setValue(selectedUsuarios.getUsuClave());
        txtUsuClave.setDisabled(false);
        txtUsuLogin.setValue(selectedUsuarios.getUsuLogin());
        txtUsuLogin.setDisabled(false);
        txtUsuNombre.setValue(selectedUsuarios.getUsuNombre());
        txtUsuNombre.setDisabled(false);
        txtUsuCedula.setValue(selectedUsuarios.getUsuCedula());
        txtUsuCedula.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedUsuarios == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new Usuarios();

            Long usuCedula = FacesUtils.checkLong(txtUsuCedula);

            entity.setTusuCodigo(FacesUtils.checkLong(txtTusuCodigo));
            entity.setUsuCedula(usuCedula);
            entity.setUsuClave(FacesUtils.checkString(txtUsuClave));
            entity.setUsuLogin(FacesUtils.checkString(txtUsuLogin));
            entity.setUsuNombre(FacesUtils.checkString(txtUsuNombre));
            businessDelegatorView.saveUsuarios(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Long usuCedula = new Long(selectedUsuarios.getUsuCedula());
                entity = businessDelegatorView.getUsuarios(usuCedula);
            }

            entity.setTusuCodigo(FacesUtils.checkLong(txtTusuCodigo));
            entity.setUsuClave(FacesUtils.checkString(txtUsuClave));
            entity.setUsuLogin(FacesUtils.checkString(txtUsuLogin));
            entity.setUsuNombre(FacesUtils.checkString(txtUsuNombre));
            businessDelegatorView.updateUsuarios(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedUsuarios = (UsuariosDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedUsuarios"));

            Long usuCedula = new Long(selectedUsuarios.getUsuCedula());
            entity = businessDelegatorView.getUsuarios(usuCedula);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long usuCedula = FacesUtils.checkLong(txtUsuCedula);
            entity = businessDelegatorView.getUsuarios(usuCedula);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteUsuarios(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String actionDeleteDataTableEditable(ActionEvent evt) {
        try {
            selectedUsuarios = (UsuariosDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedUsuarios"));

            Long usuCedula = new Long(selectedUsuarios.getUsuCedula());
            entity = businessDelegatorView.getUsuarios(usuCedula);
            businessDelegatorView.deleteUsuarios(entity);
            data.remove(selectedUsuarios);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long tusuCodigo, Long usuCedula,
        String usuClave, String usuLogin, String usuNombre)
        throws Exception {
        try {
            entity.setTusuCodigo(FacesUtils.checkLong(tusuCodigo));
            entity.setUsuClave(FacesUtils.checkString(usuClave));
            entity.setUsuLogin(FacesUtils.checkString(usuLogin));
            entity.setUsuNombre(FacesUtils.checkString(usuNombre));
            businessDelegatorView.updateUsuarios(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("UsuariosView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtTusuCodigo() {
        return txtTusuCodigo;
    }

    public void setTxtTusuCodigo(InputText txtTusuCodigo) {
        this.txtTusuCodigo = txtTusuCodigo;
    }

    public InputText getTxtUsuClave() {
        return txtUsuClave;
    }

    public void setTxtUsuClave(InputText txtUsuClave) {
        this.txtUsuClave = txtUsuClave;
    }

    public InputText getTxtUsuLogin() {
        return txtUsuLogin;
    }

    public void setTxtUsuLogin(InputText txtUsuLogin) {
        this.txtUsuLogin = txtUsuLogin;
    }

    public InputText getTxtUsuNombre() {
        return txtUsuNombre;
    }

    public void setTxtUsuNombre(InputText txtUsuNombre) {
        this.txtUsuNombre = txtUsuNombre;
    }

    public InputText getTxtUsuCedula() {
        return txtUsuCedula;
    }

    public void setTxtUsuCedula(InputText txtUsuCedula) {
        this.txtUsuCedula = txtUsuCedula;
    }

    public List<UsuariosDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataUsuarios();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<UsuariosDTO> usuariosDTO) {
        this.data = usuariosDTO;
    }

    public UsuariosDTO getSelectedUsuarios() {
        return selectedUsuarios;
    }

    public void setSelectedUsuarios(UsuariosDTO usuarios) {
        this.selectedUsuarios = usuarios;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
