package tech.oleks.eve

import grails.gorm.services.Service

@Service(Invtype)
interface InvtypeService {

    Invtype get(Serializable id)

    List<Invtype> list(Map args)

    Long count()

    void delete(Serializable id)

    Invtype save(Invtype invtype)

}