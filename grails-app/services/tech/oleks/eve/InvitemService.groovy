package tech.oleks.eve

import grails.gorm.services.Service

@Service(Invitem)
interface InvitemService {

    Invitem get(Serializable id)

    List<Invitem> list(Map args)

    Long count()

    void delete(Serializable id)

    Invitem save(Invitem invitem)

}