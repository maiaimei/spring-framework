package cn.maiaimei;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;

public class AsmTest {
	public static void main(String[] args) throws Exception {
		String path = "E:/code/spring-framework/amy-test/build/classes/java/main/cn/maiaimei/configfile/Main.class";
		FileSystemResource resource = new FileSystemResource(path);
		// 元数据解析器⼯⼚
		CachingMetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
		// 元数据解析器
		MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
		// 解析出来的类元数据
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		System.out.println(classMetadata);
	}
}
