package pattern.creational.factorymethod


/*
    Ref: https://narbase.com/2020/06/15/design-patterns-factory-method-with-kotlin-examples/
*/

interface Document {
    fun createDocumentInfo()
}

class DrawDocument: Document {
    override fun createDocumentInfo() {
        println("This is a Draw document")
    }
}

class WordDocument: Document {
    override fun createDocumentInfo() {
        println("This is a word Document")
    }
}

abstract class DocumentFactory {
    abstract fun createDocument(): Document
    companion object {
        fun getDocument(documentType: DocumentType): DocumentFactory {
            return when(documentType) {
                DocumentType.Draw -> DrawingDocumentGenerator()
                DocumentType.Word -> WordDocumentGenerator()
            }
        }
    }
}

class DrawingDocumentGenerator: DocumentFactory() {
    override fun createDocument(): Document {
        return DrawDocument()
    }
}

class WordDocumentGenerator: DocumentFactory() {
    override fun createDocument(): Document {
        return WordDocument()
    }
}

enum class DocumentType {
    Draw, Word
}


fun main() {
    val wordDocument = DocumentFactory.getDocument(DocumentType.Word)
    wordDocument.createDocument().createDocumentInfo()

    val drawDocument = DocumentFactory.getDocument(DocumentType.Draw)
    drawDocument.createDocument().createDocumentInfo()
}
