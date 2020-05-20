package com.yjy.idw.aws;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

/*
 * AWS S3에 이미지 업로드, 다운로드를 위한 클래스
 * 
 * Credentials로 인증을 하고 S3 클라이언트를 받아온다. 
 * Region은 'ap-northeast-2'로 서울 리전.
 * 
 * putObject 함수와 PutObjectRequest 함수를 통해 S3에 파일이 업로드 된다.
 * 
 */

public class S3 {
	
	public static void ImageUpload(MultipartFile uploadFile) {
		
		AWSCredentials credentials = null;
	    try {
	        credentials = new ProfileCredentialsProvider("default").getCredentials();
	    } catch (Exception e) {
	        throw new AmazonClientException(
	                "Cannot load the credentials from the credential profiles file. " +
	                "Please make sure that your credentials file is at the correct " +
	                "location (C:\\Users\\이주원\\.aws\\credentials), and is in valid format.",
	                e);
	    }
	
	    AmazonS3 s3 = AmazonS3ClientBuilder.standard()
	        .withCredentials(new AWSStaticCredentialsProvider(credentials))
	        .withRegion("ap-northeast-2")
	        .build();
	    
	    String bucketName = "idealworldcup";
	    
	    try {
	    	System.out.println("Uploading a new object to S3 from a file\n");
	        ObjectMetadata meta = new ObjectMetadata();
	        meta.setContentLength(uploadFile.getBytes().length);
	        meta.setContentType("image/jpeg");
	        s3.putObject(new PutObjectRequest(bucketName, uploadFile.getOriginalFilename(), uploadFile.getInputStream(), meta));
	        
	        /* 이미지 다운로드
	         * 
	         * System.out.println("Downloading an object");
	        S3Object object = s3.getObject(new GetObjectRequest(bucketName, "image2.jpg"));
	        System.out.println("Content-Type: "  + object.getObjectMetadata().getContentType());
	        displayTextInputStream(object.getObjectContent());
	        */
	    } 
	    
	    catch (AmazonServiceException ase) {
	        System.out.println("Caught an AmazonServiceException, which means your request made it "
	                + "to Amazon S3, but was rejected with an error response for some reason.");
	        System.out.println("Error Message:    " + ase.getMessage());
	        System.out.println("HTTP Status Code: " + ase.getStatusCode());
	        System.out.println("AWS Error Code:   " + ase.getErrorCode());
	        System.out.println("Error Type:       " + ase.getErrorType());
	        System.out.println("Request ID:       " + ase.getRequestId());
	    } catch (AmazonClientException ace) {
	        System.out.println("Caught an AmazonClientException, which means the client encountered "
	                + "a serious internal problem while trying to communicate with S3, "
	                + "such as not being able to access the network.");
	        System.out.println("Error Message: " + ace.getMessage());
	        
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
