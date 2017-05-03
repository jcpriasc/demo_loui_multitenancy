package com.vortexbird.demo.dataaccess.conf;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchemaResolver implements CurrentTenantIdentifierResolver {
	
	private static final Logger log = LoggerFactory.getLogger(SchemaResolver.class);
 
	@Override
	public String resolveCurrentTenantIdentifier() {
		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>> resolveCurrentTenantIdentifier");
		return "banco1"; //TODO: Implement service to identify tenant like: userService.getCurrentlyAuthUser().getTenantId();
	}
 
	@Override
	public boolean validateExistingCurrentSessions() {
		return false;
	}
}