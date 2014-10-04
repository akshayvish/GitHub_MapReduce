package com.soulpatch.learning.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.VIntWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class HadoopMapper extends Mapper<Text, IntWritable, Text, IntWritable>{
	@Override
	public void map(Text pKey, IntWritable pValue, Context pContext) throws IOException, InterruptedException{
		String javaFileContents = pKey.toString();
		String tokens[] = javaFileContents.split(" ");
		Long number = Long.parseLong(tokens[1]);
//		pContext.write(new Text(tokens[0]), new LongWritable(number));
	}
} 