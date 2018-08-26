package tech.oleks.eve

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InvtypeController {

    InvtypeService invtypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond invtypeService.list(params), model:[invtypeCount: invtypeService.count()]
    }

    def show(Long id) {
        respond invtypeService.get(id)
    }

    def create() {
        respond new Invtype(params)
    }

    def save(Invtype invtype) {
        if (invtype == null) {
            notFound()
            return
        }

        try {
            invtypeService.save(invtype)
        } catch (ValidationException e) {
            respond invtype.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'invtype.label', default: 'Invtype'), invtype.id])
                redirect invtype
            }
            '*' { respond invtype, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond invtypeService.get(id)
    }

    def update(Invtype invtype) {
        if (invtype == null) {
            notFound()
            return
        }

        try {
            invtypeService.save(invtype)
        } catch (ValidationException e) {
            respond invtype.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'invtype.label', default: 'Invtype'), invtype.id])
                redirect invtype
            }
            '*'{ respond invtype, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        invtypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'invtype.label', default: 'Invtype'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'invtype.label', default: 'Invtype'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
