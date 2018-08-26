package tech.oleks.eve

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MapsolarsystemController {

    MapsolarsystemService mapsolarsystemService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond mapsolarsystemService.list(params), model:[mapsolarsystemCount: mapsolarsystemService.count()]
    }

    def show(Long id) {
        respond mapsolarsystemService.get(id)
    }

    def create() {
        respond new Mapsolarsystem(params)
    }

    def save(Mapsolarsystem mapsolarsystem) {
        if (mapsolarsystem == null) {
            notFound()
            return
        }

        try {
            mapsolarsystemService.save(mapsolarsystem)
        } catch (ValidationException e) {
            respond mapsolarsystem.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mapsolarsystem.label', default: 'Mapsolarsystem'), mapsolarsystem.id])
                redirect mapsolarsystem
            }
            '*' { respond mapsolarsystem, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond mapsolarsystemService.get(id)
    }

    def update(Mapsolarsystem mapsolarsystem) {
        if (mapsolarsystem == null) {
            notFound()
            return
        }

        try {
            mapsolarsystemService.save(mapsolarsystem)
        } catch (ValidationException e) {
            respond mapsolarsystem.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mapsolarsystem.label', default: 'Mapsolarsystem'), mapsolarsystem.id])
                redirect mapsolarsystem
            }
            '*'{ respond mapsolarsystem, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        mapsolarsystemService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mapsolarsystem.label', default: 'Mapsolarsystem'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mapsolarsystem.label', default: 'Mapsolarsystem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
