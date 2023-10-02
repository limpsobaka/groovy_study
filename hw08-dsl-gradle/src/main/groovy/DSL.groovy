config {
    name = "MyTest"
    description = "Apache Tomcat"

    http {
        port = 8080
        secure = false
    }

    https {
        port = 4443
        secure = true
    }

    mappings = [
            {
                url = "/"
                active = true
            },
            {
                url = "/login"
                active = false
            }
    ]
}

def config(@DelegatesTo(Config) Closure closure) {
    def config = new Config()
    def cl = closure.rehydrate(config, this, this)
    cl.resolveStrategy = Closure.DELEGATE_ONLY
    cl()
    println(config)
}