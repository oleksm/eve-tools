package tech.oleks.eve

import grails.gorm.services.Service

@Service(Invtypereaction)
interface InvtypereactionService {

    Invtypereaction get(Serializable id)

    List<Invtypereaction> list(Map args)

    Long count()

    void delete(Serializable id)

    Invtypereaction save(Invtypereaction invtypereaction)

}