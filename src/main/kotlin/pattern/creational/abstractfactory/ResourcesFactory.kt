package pattern.creational.abstractfactory

interface Instance {
    enum class Capacity {
        Micro,
        Small,
        Large;
    }
    fun start()
    fun attachStorage(storage: Storage)
    fun stop()
}

interface Storage {
    fun getId(): String
}

class Ec2Instance: Instance {
    override fun start() {
        println("Ec2 Start Instance......")
    }

    override fun attachStorage(storage: Storage) {
        println("Attaching the storage ${storage.getId()}")
    }

    override fun stop() {
        println("Ec2 Stop Instance.......")
    }
}

class GoogleComputingInstance: Instance {
    override fun start() {
        println("GoogleComputing Start Instance......")
    }

    override fun attachStorage(storage: Storage) {
        println("Attaching the storage ${storage.getId()}")
    }

    override fun stop() {
        println("GoogleComputing Stop Instance.......")
    }
}

class S3Storage: Storage {
    override fun getId(): String {
        println("GetId for S3Storage....")
        return "s3-storage"
    }
}

class GoogleCloudStorage: Storage {
    override fun getId(): String {
        println("GetId for GoogleCloudStorage....")
        return "google-cloud-storage"
    }
}

interface ResourcesFactory {
    fun createInstance(capacity: Instance.Capacity): Instance
    fun createStorage(capacity: Int): Storage
}

class AWSResourceFactory: ResourcesFactory {
    override fun createInstance(capacity: Instance.Capacity): Ec2Instance {
        println("AWS creating Instance")
        return Ec2Instance()
    }

    override fun createStorage(capacity: Int): S3Storage {
        println("AWS creating Storage")
        return S3Storage()
    }

}


class GoogleResourceFactory: ResourcesFactory {
    override fun createInstance(capacity: Instance.Capacity): GoogleComputingInstance {
        println("Google creating Instance")
        return GoogleComputingInstance()
    }

    override fun createStorage(capacity: Int): GoogleCloudStorage {
        println("Google creating Storage")
        return GoogleCloudStorage()
    }
}

class ServerCreator(private val factory: ResourcesFactory) {
    fun create(instanceCapacity: Instance.Capacity, storage: Int): Instance {
        return factory.createInstance(instanceCapacity).apply {
            this.attachStorage(factory.createStorage(storage))
        }
    }
}

fun main() {
    ServerCreator(
        AWSResourceFactory())
        .create(Instance.Capacity.Small, 1024).also {
        it.start()
        it.stop()
    }
}
