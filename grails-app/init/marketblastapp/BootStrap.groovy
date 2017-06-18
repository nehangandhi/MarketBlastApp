package marketblastapp
import marketblastapp.Role
import marketblastapp.User
import marketblastapp.UserRole

class BootStrap {

    def init = { servletContext ->
	def adminRole = new Role(authority:'ROLE_ADMIN').save(flush: true)
 def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

 def testUser = new User(username: 'me', enabled: true, password: 'password', email: 'me@test.com', firstname: 'me', lastname: 'test')
 // , email: 'me@test.com', firstname: 'me', lastname: 'test'
testUser.save(flush: true)

 UserRole.create testUser, userRole, true

//def role = Role.findByAuthority('ROLE_USER')
//UserRole.create testUser, role, true

 assert User.count() == 5
 assert Role.count() == 2
 assert UserRole.count() == 6	
}
    def destroy = {
    }
}
