package tech.oleks.eve

import grails.gorm.services.Service

@Service(Invflag)
interface InvflagService {

    Invflag get(Serializable id)

    List<Invflag> list(Map args)

    Long count()

    void delete(Serializable id)

    Invflag save(Invflag invflag)

}