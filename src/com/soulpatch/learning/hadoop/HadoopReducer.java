package com.soulpatch.learning.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class HadoopReducer extends Reducer<Text, LongWritable, Text, LongWritable>{
	@Override
	public void reduce(Text pKey, Iterable<LongWritable> pValue, Context pContext) throws IOException, InterruptedException{
		Long maxNum = Long.MIN_VALUE;
		for(LongWritable aNum : pValue){
			maxNum = Math.max(aNum.get(), maxNum);
		}
		pContext.write(pKey, new LongWritable(maxNum));
	}
}
