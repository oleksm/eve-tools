package tech.oleks.eve

import grails.gorm.services.Service

@Service(Mapregion)
interface MapregionService {

    Mapregion get(Serializable id)

    List<Mapregion> list(Map args)

    Long count()

    void delete(Serializable id)

    Mapregion save(Mapregion mapregion)

}