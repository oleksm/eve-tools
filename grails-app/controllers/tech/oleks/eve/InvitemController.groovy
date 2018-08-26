package tech.oleks.eve

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InvitemController {

    InvitemService invitemService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond invitemService.list(params), model:[invitemCount: invitemService.count()]
    }

    def show(Long id) {
        respond invitemService.get(id)
    }

    def create() {
        respond new Invitem(params)
    }

    def save(Invitem invitem) {
        if (invitem == null) {
            notFound()
            return
        }

        try {
            invitemService.save(invitem)
        } catch (ValidationException e) {
            respond invitem.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'invitem.label', default: 'Invitem'), invitem.id])
                redirect invitem
            }
            '*' { respond invitem, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond invitemService.get(id)
    }

    def update(Invitem invitem) {
        if (invitem == null) {
            notFound()
            return
        }

        try {
            invitemService.save(invitem)
        } catch (ValidationException e) {
            respond invitem.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'invitem.label', default: 'Invitem'), invitem.id])
                redirect invitem
            }
            '*'{ respond invitem, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        invitemService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'invitem.label', default: 'Invitem'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'invitem.label', default: 'Invitem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
