package com.nuvizz.car.dao.carservice;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.car.dto.carservice.CarServiceDTO;
import com.nuvizz.car.dto.carservice.ManufacturerDTO;
import com.nuvizz.car.dto.carservice.ModelDTO;

@Component
public class CarDetailDAOImpl implements CarDetailsDAO {

	@Autowired
	private SessionFactory factory;

	public List<ManufacturerDTO> fetchManufacturer() {
		Session s = null;
		List<ManufacturerDTO> dtos = null;
		try {
			s = factory.openSession();

			String s1 = "from ManufacturerDTO";
			Query q = s.createQuery(s1);
			dtos = q.list();

		} catch (HibernateException he) {
			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}

		return dtos;
	}

	public List<ModelDTO> fetchModel(String manu) {
		Session s = null;
		List<ModelDTO> dtos = null;
		try {
			s = factory.openSession();

			String s1 = "select model from ModelDTO model where model.manufacturer='"
					+ manu + "'";
			Query q = s.createQuery(s1);
			dtos = q.list();

		} catch (HibernateException he) {
			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}

		return dtos;
	}

	public boolean save(CarServiceDTO dto) {
		System.out.println("Starting save DAO");
		boolean res = false;
		if (dto != null) {

			Session s = null;
			Transaction t = null;

			try {
				s = factory.openSession();
				t = s.beginTransaction();
				s.save(dto);
				t.commit();
				res = true;
			} catch (HibernateException he) {
				t.rollback();
				System.err.println("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				s.close();
			}

		}

		System.out.println("Ending save DAO");
		return res;

	}

	public Date check(CarServiceDTO dto) {
		Session s = null;
		boolean res = false;
		CarServiceDTO fDto = null;
		Date date = null;
		String vno = dto.getVehicleNo();
		System.out.println("vno=" + vno);
		try {
			s = factory.openSession();

			String s1 = "select car from CarServiceDTO car where car.vehicleNo='"
					+ vno + "'";
			Query q = s.createQuery(s1);
			fDto = (CarServiceDTO) q.uniqueResult();
			System.out.println("fdto" + fDto);
			if (fDto != null) {
				date = fDto.getDate();

			}

		} catch (HibernateException he) {
			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}

		return date;
	}

	public List<CarServiceDTO> callProcedure(String name) {
		Session s = null;
		List<CarServiceDTO> dtos = null;
		try {
			s = factory.openSession();

			//String s1 = "from ManufacturerDTO";
			//Query q = s.createQuery(s1);
			Query q=s.createSQLQuery("call getChassisNo(:name)").addEntity(CarServiceDTO.class).setParameter("name", name);
			
			
			dtos = q.list();

		} catch (HibernateException he) {
			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}

		return dtos;
	}

}
