package natmo2



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TesteController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Teste.list(params), model:[testeInstanceCount: Teste.count()]
    }

    def show(Teste testeInstance) {
        //respond testeInstance
    }

    def create() {
        respond new Teste(params)
    }

    @Transactional
    def save(Teste testeInstance) {
        if (testeInstance == null) {
            notFound()
            return
        }

        if (testeInstance.hasErrors()) {
            respond testeInstance.errors, view:'create'
            return
        }
		
        testeInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'testeInstance.label', default: 'Teste'), testeInstance.id])
                redirect testeInstance
            }
            '*' { respond testeInstance, [status: CREATED] }
        }
    }

    def edit(Teste testeInstance) {
        respond testeInstance
    }

    @Transactional
    def update(Teste testeInstance) {
        if (testeInstance == null) {
            notFound()
            return
        }

        if (testeInstance.hasErrors()) {
            respond testeInstance.errors, view:'edit'
            return
        }

        testeInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Teste.label', default: 'Teste'), testeInstance.id])
                redirect testeInstance
            }
            '*'{ respond testeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Teste testeInstance) {

        if (testeInstance == null) {
            notFound()
            return
        }

        testeInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Teste.label', default: 'Teste'), testeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'testeInstance.label', default: 'Teste'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
