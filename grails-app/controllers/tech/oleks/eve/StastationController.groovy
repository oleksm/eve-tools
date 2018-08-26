package tech.oleks.eve

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class StastationController {

    StastationService stastationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond stastationService.list(params), model:[stastationCount: stastationService.count()]
    }

    def show(Long id) {
        respond stastationService.get(id)
    }

    def create() {
        respond new Stastation(params)
    }

    def save(Stastation stastation) {
        if (stastation == null) {
            notFound()
            return
        }

        try {
            stastationService.save(stastation)
        } catch (ValidationException e) {
            respond stastation.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'stastation.label', default: 'Stastation'), stastation.id])
                redirect stastation
            }
            '*' { respond stastation, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond stastationService.get(id)
    }

    def update(Stastation stastation) {
        if (stastation == null) {
            notFound()
            return
        }

        try {
            stastationService.save(stastation)
        } catch (ValidationException e) {
            respond stastation.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'stastation.label', default: 'Stastation'), stastation.id])
                redirect stastation
            }
            '*'{ respond stastation, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        stastationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'stastation.label', default: 'Stastation'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'stastation.label', default: 'Stastation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
