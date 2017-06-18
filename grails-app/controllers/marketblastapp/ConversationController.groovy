package marketblastapp

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ConversationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Conversation.list(params), model:[conversationCount: Conversation.count()]
    }

    @Secured(['ROLE_USER'])
    def show(Conversation conversation) {
        respond conversation
    }

    @Secured(['ROLE_USER'])
    def create() {
        respond new Conversation(params)
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def save(Conversation conversation) {
        if (conversation == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (conversation.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond conversation.errors, view:'create'
            return
        }

        conversation.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'conversation.label', default: 'Conversation'), conversation.id])
                redirect conversation
            }
            '*' { respond conversation, [status: CREATED] }
        }
    }

    @Secured(['ROLE_USER'])
    def edit(Conversation conversation) {
        respond conversation
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def update(Conversation conversation) {
        if (conversation == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (conversation.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond conversation.errors, view:'edit'
            return
        }

        conversation.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'conversation.label', default: 'Conversation'), conversation.id])
                redirect conversation
            }
            '*'{ respond conversation, [status: OK] }
        }
    }

    @Transactional
    @Secured(['ROLE_USER'])
    def delete(Conversation conversation) {

        if (conversation == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        conversation.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'conversation.label', default: 'Conversation'), conversation.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'conversation.label', default: 'Conversation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
