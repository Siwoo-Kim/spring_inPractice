package com.springInPractice.chapter2.repository;

import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.util.ReflectionUtils;

import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

@Log
public class AbstractHibernateRepository<T extends Object> implements GenericRepository<T> {

    @Inject private SessionFactory sessionFactory;
    private Class<T> domainClass;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    private Class<T> getDomainClass(){
        if(domainClass == null){
            ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            log.warning(getClass().getGenericSuperclass().toString());
            log.warning(thisType::toString);
            this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
        }
        return this.domainClass;
    }

    private String getDomainClassName(){
        return getDomainClass().getName();
    }

    @Override
    public void create(T t) {
        Method method = ReflectionUtils.findMethod(getDomainClass(),"setDateCreated",new Class[]{Date.class});
        if(method != null){
            try{
                method.invoke(t,new Date());
            }catch (Exception e){ /* Ignore */ }
        }
        getSession().save(t);
    }

    @Override
    public T get(Serializable id) {
        return  getSession().get(getDomainClass(),id);
    }

    @Override
    public T load(Serializable id) {
        return getSession().load(getDomainClass(),id);
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delete(T t) {

    }

    @Override
    public void deleteById(Serializable id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean exists(Serializable id) {
        return false;
    }
}
