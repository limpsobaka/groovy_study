import groovy.transform.ToString

@ToString
class Config {
    def name
    def description
    def http
    def https
    def mappings = []

    def http(@DelegatesTo(HTTP) Closure closure) {
        http = new HTTP()
        def cl = closure.rehydrate(http, this, this)
        cl.resolveStrategy = Closure.DELEGATE_ONLY
        cl()
    }

    def https(@DelegatesTo(HTTPS) Closure closure) {
        https = new HTTPS()
        def cl = closure.rehydrate(https, this, this)
        cl.resolveStrategy = Closure.DELEGATE_ONLY
        cl()
    }

    def setMappings(List list) {
        list.each {
            def map = [:]
            map.with(it)
            mappings.add(map)
        }
    }
}
