package com.vortexbird.demo.presentation.backingBeans;

import com.vortexbird.demo.exceptions.*;
import com.vortexbird.demo.modelo.*;
import com.vortexbird.demo.modelo.dto.ConsignacionesDTO;
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
public class ConsignacionesView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ConsignacionesView.class);
    private InputText txtConDescripcion;
    private InputText txtConValor;
    private InputText txtUsuCedula;
    private InputText txtConCodigo;
    private InputText txtCueNumero;
    private Calendar txtConFecha;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ConsignacionesDTO> data;
    private ConsignacionesDTO selectedConsignaciones;
    private Consignaciones entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ConsignacionesView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            ConsignacionesDTO consignacionesDTO = (ConsignacionesDTO) e.getObject();

            if (txtConDescripcion == null) {
                txtConDescripcion = new InputText();
            }

            txtConDescripcion.setValue(consignacionesDTO.getConDescripcion());

            if (txtConValor == null) {
                txtConValor = new InputText();
            }

            txtConValor.setValue(consignacionesDTO.getConValor());

            if (txtUsuCedula == null) {
                txtUsuCedula = new InputText();
            }

            txtUsuCedula.setValue(consignacionesDTO.getUsuCedula());

            if (txtConCodigo == null) {
                txtConCodigo = new InputText();
            }

            txtConCodigo.setValue(consignacionesDTO.getConCodigo());

            if (txtCueNumero == null) {
                txtCueNumero = new InputText();
            }

            txtCueNumero.setValue(consignacionesDTO.getCueNumero());

            if (txtConFecha == null) {
                txtConFecha = new Calendar();
            }

            txtConFecha.setValue(consignacionesDTO.getConFecha());

            ConsignacionesId id = new ConsignacionesId();
            id.setConCodigo((((txtConCodigo.getValue()) == null) ||
                (txtConCodigo.getValue()).equals("")) ? null
                                                      : FacesUtils.checkLong(
                    txtConCodigo));
            id.setCueNumero((((txtCueNumero.getValue()) == null) ||
                (txtCueNumero.getValue()).equals("")) ? null
                                                      : FacesUtils.checkString(
                    txtCueNumero));
            entity = businessDelegatorView.getConsignaciones(id);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedConsignaciones = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedConsignaciones = null;

        if (txtConDescripcion != null) {
            txtConDescripcion.setValue(null);
            txtConDescripcion.setDisabled(true);
        }

        if (txtConValor != null) {
            txtConValor.setValue(null);
            txtConValor.setDisabled(true);
        }

        if (txtUsuCedula != null) {
            txtUsuCedula.setValue(null);
            txtUsuCedula.setDisabled(true);
        }

        if (txtConFecha != null) {
            txtConFecha.setValue(null);
            txtConFecha.setDisabled(true);
        }

        if (txtConCodigo != null) {
            txtConCodigo.setValue(null);
            txtConCodigo.setDisabled(false);
        }

        if (txtCueNumero != null) {
            txtCueNumero.setValue(null);
            txtCueNumero.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtConFecha() {
        Date inputDate = (Date) txtConFecha.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            ConsignacionesId id = new ConsignacionesId();
            id.setConCodigo((((txtConCodigo.getValue()) == null) ||
                (txtConCodigo.getValue()).equals("")) ? null
                                                      : FacesUtils.checkLong(
                    txtConCodigo));
            id.setCueNumero((((txtCueNumero.getValue()) == null) ||
                (txtCueNumero.getValue()).equals("")) ? null
                                                      : FacesUtils.checkString(
                    txtCueNumero));
            entity = (id != null) ? businessDelegatorView.getConsignaciones(id)
                                  : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtConDescripcion.setDisabled(false);
            txtConValor.setDisabled(false);
            txtUsuCedula.setDisabled(false);
            txtConFecha.setDisabled(false);
            txtConCodigo.setDisabled(false);
            txtCueNumero.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtConDescripcion.setValue(entity.getConDescripcion());
            txtConDescripcion.setDisabled(false);
            txtConFecha.setValue(entity.getConFecha());
            txtConFecha.setDisabled(false);
            txtConValor.setValue(entity.getConValor());
            txtConValor.setDisabled(false);
            txtUsuCedula.setValue(entity.getUsuCedula());
            txtUsuCedula.setDisabled(false);
            txtConCodigo.setValue(entity.getId().getConCodigo());
            txtConCodigo.setDisabled(true);
            txtCueNumero.setValue(entity.getId().getCueNumero());
            txtCueNumero.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedConsignaciones = (ConsignacionesDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedConsignaciones"));
        txtConDescripcion.setValue(selectedConsignaciones.getConDescripcion());
        txtConDescripcion.setDisabled(false);
        txtConFecha.setValue(selectedConsignaciones.getConFecha());
        txtConFecha.setDisabled(false);
        txtConValor.setValue(selectedConsignaciones.getConValor());
        txtConValor.setDisabled(false);
        txtUsuCedula.setValue(selectedConsignaciones.getUsuCedula());
        txtUsuCedula.setDisabled(false);
        txtConCodigo.setValue(selectedConsignaciones.getConCodigo());
        txtConCodigo.setDisabled(true);
        txtCueNumero.setValue(selectedConsignaciones.getCueNumero());
        txtCueNumero.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedConsignaciones == null) && (entity == null)) {
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
            entity = new Consignaciones();

            ConsignacionesId id = new ConsignacionesId();
            id.setConCodigo((((txtConCodigo.getValue()) == null) ||
                (txtConCodigo.getValue()).equals("")) ? null
                                                      : FacesUtils.checkLong(
                    txtConCodigo));
            id.setCueNumero((((txtCueNumero.getValue()) == null) ||
                (txtCueNumero.getValue()).equals("")) ? null
                                                      : FacesUtils.checkString(
                    txtCueNumero));

            entity.setConDescripcion(FacesUtils.checkString(txtConDescripcion));
            entity.setConFecha(FacesUtils.checkDate(txtConFecha));
            entity.setConValor(FacesUtils.checkDouble(txtConValor));
            entity.setId(id);
            entity.setUsuCedula(FacesUtils.checkLong(txtUsuCedula));
            businessDelegatorView.saveConsignaciones(entity);
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
                ConsignacionesId id = new ConsignacionesId();
                id.setConCodigo(selectedConsignaciones.getConCodigo());
                id.setCueNumero(selectedConsignaciones.getCueNumero());
                entity = businessDelegatorView.getConsignaciones(id);
            }

            entity.setConDescripcion(FacesUtils.checkString(txtConDescripcion));
            entity.setConFecha(FacesUtils.checkDate(txtConFecha));
            entity.setConValor(FacesUtils.checkDouble(txtConValor));
            entity.setUsuCedula(FacesUtils.checkLong(txtUsuCedula));
            businessDelegatorView.updateConsignaciones(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedConsignaciones = (ConsignacionesDTO) (evt.getComponent()
                                                             .getAttributes()
                                                             .get("selectedConsignaciones"));

            ConsignacionesId id = new ConsignacionesId();
            id.setConCodigo(selectedConsignaciones.getConCodigo());
            id.setCueNumero(selectedConsignaciones.getCueNumero());
            entity = businessDelegatorView.getConsignaciones(id);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            ConsignacionesId id = new ConsignacionesId();
            id.setConCodigo((((txtConCodigo.getValue()) == null) ||
                (txtConCodigo.getValue()).equals("")) ? null
                                                      : FacesUtils.checkLong(
                    txtConCodigo));
            id.setCueNumero((((txtCueNumero.getValue()) == null) ||
                (txtCueNumero.getValue()).equals("")) ? null
                                                      : FacesUtils.checkString(
                    txtCueNumero));
            entity = businessDelegatorView.getConsignaciones(id);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteConsignaciones(entity);
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
            selectedConsignaciones = (ConsignacionesDTO) (evt.getComponent()
                                                             .getAttributes()
                                                             .get("selectedConsignaciones"));

            ConsignacionesId id = new ConsignacionesId();
            id.setConCodigo(selectedConsignaciones.getConCodigo());
            id.setCueNumero(selectedConsignaciones.getCueNumero());
            entity = businessDelegatorView.getConsignaciones(id);
            businessDelegatorView.deleteConsignaciones(entity);
            data.remove(selectedConsignaciones);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long conCodigo, String cueNumero,
        String conDescripcion, Date conFecha, Double conValor, Long usuCedula)
        throws Exception {
        try {
            entity.setConDescripcion(FacesUtils.checkString(conDescripcion));
            entity.setConFecha(FacesUtils.checkDate(conFecha));
            entity.setConValor(FacesUtils.checkDouble(conValor));
            entity.setUsuCedula(FacesUtils.checkLong(usuCedula));
            businessDelegatorView.updateConsignaciones(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ConsignacionesView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtConDescripcion() {
        return txtConDescripcion;
    }

    public void setTxtConDescripcion(InputText txtConDescripcion) {
        this.txtConDescripcion = txtConDescripcion;
    }

    public InputText getTxtConValor() {
        return txtConValor;
    }

    public void setTxtConValor(InputText txtConValor) {
        this.txtConValor = txtConValor;
    }

    public InputText getTxtUsuCedula() {
        return txtUsuCedula;
    }

    public void setTxtUsuCedula(InputText txtUsuCedula) {
        this.txtUsuCedula = txtUsuCedula;
    }

    public Calendar getTxtConFecha() {
        return txtConFecha;
    }

    public void setTxtConFecha(Calendar txtConFecha) {
        this.txtConFecha = txtConFecha;
    }

    public InputText getTxtConCodigo() {
        return txtConCodigo;
    }

    public void setTxtConCodigo(InputText txtConCodigo) {
        this.txtConCodigo = txtConCodigo;
    }

    public InputText getTxtCueNumero() {
        return txtCueNumero;
    }

    public void setTxtCueNumero(InputText txtCueNumero) {
        this.txtCueNumero = txtCueNumero;
    }

    public List<ConsignacionesDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataConsignaciones();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ConsignacionesDTO> consignacionesDTO) {
        this.data = consignacionesDTO;
    }

    public ConsignacionesDTO getSelectedConsignaciones() {
        return selectedConsignaciones;
    }

    public void setSelectedConsignaciones(ConsignacionesDTO consignaciones) {
        this.selectedConsignaciones = consignaciones;
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
