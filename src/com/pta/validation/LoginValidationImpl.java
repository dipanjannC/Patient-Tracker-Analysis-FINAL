package com.pta.validation;

import com.pta.model.AdminPOJO;

public class LoginValidationImpl implements LoginValidation {

	public boolean loginValidation(AdminPOJO pojo) {
		boolean flag = true;
		String idString = pojo.getAdminId();
		if (idString.substring(0, 2) == "ADN") {
			String id = idString.substring(3);
			for (int i = 0; i < id.length(); i++) {
				if (Character.isDigit(id.charAt(i)) == false) {
					flag = false;
					break;
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}

}
