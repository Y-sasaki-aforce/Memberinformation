package jp.co.aforce.tool;

import jp.co.aforce.bean.Bean;

public class Check {

	public Bean put(
			String last_name,
			String first_name,
			String sex,
			String birth_year,
			String birth_month,
			String birth_day,
			String job,
			String phone_number,
			String mail_address
			) throws Exception {

				Bean bean = null;

		int yearInt = Integer.parseInt(birth_year);
		int monthInt = Integer.parseInt(birth_month);
		int dayInt = Integer.parseInt(birth_day);

		bean = new Bean(
				last_name,
				first_name,
				sex,
				yearInt,
				monthInt,
				dayInt,
				job,
				phone_number,
				mail_address
				);

		return bean;
	}

}
