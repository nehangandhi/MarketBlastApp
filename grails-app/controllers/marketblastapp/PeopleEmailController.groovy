package marketblastapp

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PeopleEmailController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PeopleEmail.list(params), model:[peopleEmailCount: PeopleEmail.count()]
    }

    @Secured(['ROLE_USER'])
    def show(PeopleEmail peopleEmail) {
        respond peopleEmail
    }

    @Secured(['ROLE_USER'])
    def create() {
        respond new PeopleEmail(params)
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def save(PeopleEmail peopleEmail) {
        if (peopleEmail == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (peopleEmail.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond peopleEmail.errors, view:'create'
            return
        }

        peopleEmail.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'peopleEmail.label', default: 'PeopleEmail'), peopleEmail.id])
                redirect peopleEmail
            }
            '*' { respond peopleEmail, [status: CREATED] }
        }
    }

    @Secured(['ROLE_USER'])
    def edit(PeopleEmail peopleEmail) {
        respond peopleEmail
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def update(PeopleEmail peopleEmail) {
        if (peopleEmail == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (peopleEmail.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond peopleEmail.errors, view:'edit'
            return
        }

        peopleEmail.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'peopleEmail.label', default: 'PeopleEmail'), peopleEmail.id])
                redirect peopleEmail
            }
            '*'{ respond peopleEmail, [status: OK] }
        }
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def delete(PeopleEmail peopleEmail) {

        if (peopleEmail == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        peopleEmail.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'peopleEmail.label', default: 'PeopleEmail'), peopleEmail.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'peopleEmail.label', default: 'PeopleEmail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
