package tech.oleks.eve

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InvflagController {

    InvflagService invflagService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond invflagService.list(params), model:[invflagCount: invflagService.count()]
    }

    def show(Long id) {
        respond invflagService.get(id)
    }

    def create() {
        respond new Invflag(params)
    }

    def save(Invflag invflag) {
        if (invflag == null) {
            notFound()
            return
        }

        try {
            invflagService.save(invflag)
        } catch (ValidationException e) {
            respond invflag.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'invflag.label', default: 'Invflag'), invflag.id])
                redirect invflag
            }
            '*' { respond invflag, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond invflagService.get(id)
    }

    def update(Invflag invflag) {
        if (invflag == null) {
            notFound()
            return
        }

        try {
            invflagService.save(invflag)
        } catch (ValidationException e) {
            respond invflag.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'invflag.label', default: 'Invflag'), invflag.id])
                redirect invflag
            }
            '*'{ respond invflag, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        invflagService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'invflag.label', default: 'Invflag'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'invflag.label', default: 'Invflag'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
