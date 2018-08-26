package tech.oleks.eve

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InvtypereactionController {

    InvtypereactionService invtypereactionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond invtypereactionService.list(params), model:[invtypereactionCount: invtypereactionService.count()]
    }

    def show(Long id) {
        respond invtypereactionService.get(id)
    }

    def create() {
        respond new Invtypereaction(params)
    }

    def save(Invtypereaction invtypereaction) {
        if (invtypereaction == null) {
            notFound()
            return
        }

        try {
            invtypereactionService.save(invtypereaction)
        } catch (ValidationException e) {
            respond invtypereaction.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'invtypereaction.label', default: 'Invtypereaction'), invtypereaction.id])
                redirect invtypereaction
            }
            '*' { respond invtypereaction, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond invtypereactionService.get(id)
    }

    def update(Invtypereaction invtypereaction) {
        if (invtypereaction == null) {
            notFound()
            return
        }

        try {
            invtypereactionService.save(invtypereaction)
        } catch (ValidationException e) {
            respond invtypereaction.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'invtypereaction.label', default: 'Invtypereaction'), invtypereaction.id])
                redirect invtypereaction
            }
            '*'{ respond invtypereaction, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        invtypereactionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'invtypereaction.label', default: 'Invtypereaction'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'invtypereaction.label', default: 'Invtypereaction'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
