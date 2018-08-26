package tech.oleks.eve

import grails.gorm.services.Service

@Service(Stastation)
interface StastationService {

    Stastation get(Serializable id)

    List<Stastation> list(Map args)

    Long count()

    void delete(Serializable id)

    Stastation save(Stastation stastation)

}