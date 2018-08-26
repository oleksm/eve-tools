package tech.oleks.eve

import grails.gorm.services.Service

@Service(Mapsolarsystem)
interface MapsolarsystemService {

    Mapsolarsystem get(Serializable id)

    List<Mapsolarsystem> list(Map args)

    Long count()

    void delete(Serializable id)

    Mapsolarsystem save(Mapsolarsystem mapsolarsystem)

}