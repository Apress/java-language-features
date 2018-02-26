// module-info.java
module jdojo.annotation.processor {
    exports com.jdojo.annotation.processor;
    requires jdojo.annotation;
    requires java.compiler;
    provides javax.annotation.processing.Processor 
        with com.jdojo.annotation.processor.VersionProcessor;
}
