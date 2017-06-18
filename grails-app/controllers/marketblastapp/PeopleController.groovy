package marketblastapp

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PeopleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond People.list(params), model:[peopleCount: People.count()]
    }

    @Secured(['ROLE_USER'])
    def show(People people) {
        respond people
    }

    @Secured(['ROLE_USER'])
    def create() {
        respond new People(params)
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def save(People people) {
        if (people == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (people.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond people.errors, view:'create'
            return
        }

        people.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'people.label', default: 'People'), people.id])
                redirect people
            }
            '*' { respond people, [status: CREATED] }
        }
    }

    @Secured(['ROLE_USER'])
    def edit(People people) {
        respond people
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def update(People people) {
        if (people == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (people.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond people.errors, view:'edit'
            return
        }

        people.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'people.label', default: 'People'), people.id])
                redirect people
            }
            '*'{ respond people, [status: OK] }
        }
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def delete(People people) {

        if (people == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        people.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'people.label', default: 'People'), people.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'people.label', default: 'People'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
