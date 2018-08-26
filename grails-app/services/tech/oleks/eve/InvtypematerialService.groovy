package tech.oleks.eve

import grails.gorm.services.Service

@Service(Invtypematerial)
interface InvtypematerialService {

    Invtypematerial get(Serializable id)

    List<Invtypematerial> list(Map args)

    Long count()

    void delete(Serializable id)

    Invtypematerial save(Invtypematerial invtypematerial)

}