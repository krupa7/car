package com.nuvizz.busticket.dao.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.busticket.dto.OrderDTO;
import com.nuvizz.busticket.dto.ProviderDTO;
import com.nuvizz.busticket.dto.RoleDTO;
import com.nuvizz.busticket.dto.ServiceDTO;

@Component
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory factory;

	private static final Logger logger = LoggerFactory
			.getLogger(AdminDAOImpl.class);

	public List<ProviderDTO> fetchProviders() {
		logger.info("starting fetch provider dao");
		Session s = null;
		List<ProviderDTO> dtos = null;
		try {
			s = factory.openSession();

			String s1 = "from ProviderDTO";
			Query q = s.createQuery(s1);
			dtos = q.list();

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}
		logger.info("ending fetch provider dao");
		return dtos;
	}

	public boolean addProvider(ProviderDTO dto) {
		logger.info("Starting add pro DAO");
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
				logger.error("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				s.close();
			}

		}

		logger.info("Ending add pro DAO");
		return res;
	}

	public ProviderDTO getProvider(int id) {
		logger.info("Inside getProvider dao");

		ProviderDTO fromDB = null;

		if (id > 0) {
			Session session = null;
			try {
				session = factory.openSession();

				String s1 = "select pro from ProviderDTO pro where pro.pid=:id";
				Query q = session.createQuery(s1);
				q.setParameter("id", id);
				fromDB = (ProviderDTO) q.uniqueResult();

			} catch (HibernateException he) {
				logger.error("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				session.close();
			}
		}
		logger.info("exiting getProvider dao");

		return fromDB;
	}

	public boolean updateProvider(ProviderDTO dto) {
		logger.info("inside updateProvider dao");
		Session s = null;
		boolean res = false;
		Transaction t = null;
		try {

			if (dto != null) {
				s = factory.openSession();
				t = s.beginTransaction();
				s.saveOrUpdate(dto);
				res = true;
				t.commit();
			}

		} catch (HibernateException he) {
			t.rollback();
			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}
		logger.info("exiting updateProvider dao");
		return res;

	}

	public boolean deleteProvider(int id) {
		logger.info("inside deleteProvider dao");
		Session s = null;
		boolean res = false;
		Transaction t = null;
		try {

			if (id > 0) {
				s = factory.openSession();
				t = s.beginTransaction();
				String str = "delete from ProviderDTO p where p.pid=" + id;
				Query query = s.createQuery(str);
				query.executeUpdate();
				res = true;
				t.commit();
			}

		} catch (HibernateException he) {
			t.rollback();
			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}
		logger.info("exiting deleteProvider dao");
		return res;

	}

	public List<ServiceDTO> fetchService(int id) {
		logger.info("Inside fetch service dao");

		List<ServiceDTO> fromDB = null;

		if (id > 0) {
			Session session = null;
			try {
				session = factory.openSession();

				String s1 = "select ser from ServiceDTO ser where ser.id=:id";
				Query q = session.createQuery(s1);
				q.setParameter("id", id);
				fromDB = (List<ServiceDTO>) q.list();

			} catch (HibernateException he) {
				logger.error("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				session.close();
			}
		}
		logger.info("exiting fetch service dao");

		return fromDB;
	}

	public boolean addService(ServiceDTO dto) {
		logger.info("Starting add service DAO");
		boolean res = false;
		if (dto != null) {

			Session s = null;
			Transaction t = null;

			try {
				s = factory.openSession();
				t = s.beginTransaction();
				Date d = dto.getDdate();
				SimpleDateFormat dt = new SimpleDateFormat(
						"yyyy-MM-dd");
				//Date date = dt.format(d);
				s.save(dto);
				t.commit();
				res = true;
			} catch (HibernateException he) {
				t.rollback();
				logger.error("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				s.close();
			}

		}

		logger.info("Ending add service DAO");
		return res;
	}

	public ServiceDTO getBusService(int id) {
		logger.info("Inside getBus dao");

		ServiceDTO fromDB = null;

		if (id > 0) {
			Session session = null;
			try {
				session = factory.openSession();

				String s1 = "select ser from ServiceDTO ser where ser.id=:id";
				Query q = session.createQuery(s1);
				q.setParameter("id", id);
				fromDB = (ServiceDTO) q.uniqueResult();

			} catch (HibernateException he) {
				logger.error("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				session.close();
			}
		}
		logger.info("exiting getProvider dao");

		return fromDB;

	}

	public boolean updateService(ServiceDTO dto) {
		logger.info("inside updateservice dao");
		Session s = null;
		boolean res = false;
		Transaction t = null;
		try {

			if (dto != null) {
				s = factory.openSession();
				t = s.beginTransaction();

				s.merge(dto);
				res = true;
				t.commit();
			}

		} catch (HibernateException he) {
			t.rollback();
			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}
		logger.info("exiting updateService dao");
		return res;
	}

	public boolean deleteService(int id) {
		logger.info("inside deleteService dao");
		Session s = null;
		boolean res = false;
		Transaction t = null;
		try {

			if (id > 0) {
				s = factory.openSession();
				t = s.beginTransaction();
				String str = "delete from ServiceDTO s where s.id=" + id;
				Query query = s.createQuery(str);
				query.executeUpdate();
				res = true;
				t.commit();
			}

		} catch (HibernateException he) {
			t.rollback();
			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}
		logger.info("exiting deleteService dao");
		return res;
	}

	public ProviderDTO getProviderByName(String name) {
		logger.info("Inside getProvider dao");

		ProviderDTO fromDB = null;

		if (name != null) {
			Session session = null;
			try {
				session = factory.openSession();

				String s1 = "select pro from ProviderDTO pro where pro.pname=:name";
				Query q = session.createQuery(s1);
				q.setParameter("name", name);
				fromDB = (ProviderDTO) q.uniqueResult();

			} catch (HibernateException he) {
				logger.error("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				session.close();
			}
		}
		logger.info("exiting getProvider dao");

		return fromDB;
	}

	public List<OrderDTO> fetchOrder() {
		logger.info("Inside fetch order dao");

		List<OrderDTO> dtos = null;
		Session session = null;
		try {
			session = factory.openSession();

			String s1 = "from OrderDTO";
			Query q = session.createQuery(s1);
			dtos = q.list();

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("ending fetch order dao");

		return dtos;
	}

}
