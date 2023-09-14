import groovy.json.JsonSlurper
import groovy.xml.MarkupBuilder

class Main {
    static String jsonFile = './jsonFile.json'
    static String htmlFile = './htmlFile.html'
    static String xmlFile = './xmlFile.xml'
    static String downloadUrl = 'https://raw.githubusercontent.com/Groovy-Developer/groovy-2023-07-hw/main/test.json'

    static void main(String[] args) {
        downloadFile()
        def jsonObject = new JsonSlurper().parse(new File(jsonFile))
        buildHTMLFile(jsonObject)
        buildXMLFile(jsonObject)
    }

    static void downloadFile() {
        def destinationFile = new File(jsonFile)
        destinationFile.withOutputStream { it << new URL(downloadUrl).newInputStream() }
    }

    static void buildHTMLFile(def jsonObject) {
        def htmlBuilder = new MarkupBuilder(new FileWriter(htmlFile))
        htmlBuilder.html {
            head {}
            body {
                div {
                    div('id': 'employee') {
                        p jsonObject.name
                        p jsonObject.age
                        p jsonObject.secretIdentity
                        ul('id': 'powers') {
                            jsonObject.powers.each {
                                li it
                            }
                        }
                    }
                }
            }
        }
    }

    static void buildXMLFile(def jsonObject) {
        def htmlBuilder = new MarkupBuilder(new FileWriter(xmlFile))
        htmlBuilder.xml {
            div {
                div('id': 'employee') {
                    name jsonObject.name
                    age jsonObject.age
                    secretIdentity jsonObject.secretIdentity
                    powers('id': 'powers') {
                        jsonObject.powers.each {
                            power it
                        }
                    }
                }
            }
        }
    }
}
