package tech.oleks.eve

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MapregionController {

    MapregionService mapregionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond mapregionService.list(params), model:[mapregionCount: mapregionService.count()]
    }

    def show(Long id) {
        respond mapregionService.get(id)
    }

    def create() {
        respond new Mapregion(params)
    }

    def save(Mapregion mapregion) {
        if (mapregion == null) {
            notFound()
            return
        }

        try {
            mapregionService.save(mapregion)
        } catch (ValidationException e) {
            respond mapregion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mapregion.label', default: 'Mapregion'), mapregion.id])
                redirect mapregion
            }
            '*' { respond mapregion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond mapregionService.get(id)
    }

    def update(Mapregion mapregion) {
        if (mapregion == null) {
            notFound()
            return
        }

        try {
            mapregionService.save(mapregion)
        } catch (ValidationException e) {
            respond mapregion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mapregion.label', default: 'Mapregion'), mapregion.id])
                redirect mapregion
            }
            '*'{ respond mapregion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        mapregionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mapregion.label', default: 'Mapregion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mapregion.label', default: 'Mapregion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
