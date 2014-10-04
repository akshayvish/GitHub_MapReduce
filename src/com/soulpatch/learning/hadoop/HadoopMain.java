package com.soulpatch.learning.hadoop;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;

import com.soulpatch.github.GitRequests;

public class HadoopMain {
	
	private static String INPUT_PATH = "/Users/akshayviswanathan/Documents/workspace/MapReduce_Hadoop/inputFiles";
	private static String OUTPUT_PATH = "/Users/akshayviswanathan/Documents/workspace/MapReduce_Hadoop/output";
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
		Job job = new Job();
		job.setJarByClass(HadoopMapper.class);
		job.setJobName("Max Number");
		
//		FileInputFormat.addInputPath(job, new Path(INPUT_PATH));
//        FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));
		
		
        
        job.setMapperClass(HadoopMapper.class);
        job.setReducerClass(HadoopReducer.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        
        GitRequests gitReq = new GitRequests();
        
        System.exit(job.waitForCompletion(true)?0:1);
	}
}
