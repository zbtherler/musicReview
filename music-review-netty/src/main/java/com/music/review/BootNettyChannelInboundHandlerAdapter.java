package com.music.review;

import java.io.IOException;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.music.review.vo.RecordUploadDetailVo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class BootNettyChannelInboundHandlerAdapter extends ChannelInboundHandlerAdapter{

	 /**
     * 从客户端收到新的数据时，这个方法会在收到消息时被调用
     *
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception, IOException
    {
//    	String data = "dd54142003531413090a111a3100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003030000921f00002500000000\n";
		System.out.println("channelRead:read msg:" + msg.toString());
		String data = msg.toString();
		if(data.equals("GCLOCK")) {
		    //回应客户端
	        ctx.write("+GCLOCK:20190910172522.");
		}else {
			
//			String data1 = "{\"macAddress\":\"dd5414200353\",\"brushTeethTime\":\"2011-09-19 12:15:47\",\"brushTeethDuration\":61,\"outLeftUpXBrushCount\":4,\"outLeftUpYBrushCount\":0,\"outLeftUp45DegreeCount\":5,\"outLeftUpWhiskCount\":0,\"outLeftUpBrushTime\":4,\"outLeftDownXBrushCount\":4,\"outLeftDownYBrushCount\":0,\"outLeftDown45DegreeCount\":0,\"outLeftDownWhiskCount\":0,\"outLeftDownBrushTime\":1,\"outCenterUpXBrushCount\":0,\"outCenterUpYBrushCount\":0,\"outCenterUp45DegreeBrushCount\":7,\"outCenterUpWhiskCount\":0,\"outCenterUpBrushTime\":1,\"outCenterDownXBrushCount\":0,\"outCenterDownYBrushCount\":0,\"outCenterDown45DegreeBrushCount\":0,\"outCenterDownWhiskCount\":0,\"outCenterDownBrushTime\":0,\"outRightUpXBrushCount\":1,\"outRightUpYBrushCount\":1,\"outRightUp45DegreeBrushCount\":0,\"outRightUpWhiskCount\":1,\"outRightUpBrushTime\":2,\"outRightDownXBrushCount\":1,\"outRightDownYBrushCount\":1,\"outRightDown45DegreeBrushCount\":0,\"outRightDownWhiskCount\":1,\"outRightDownBrushTime\":1,\"innerLeftUpBrushCount\":6,\"innerLeftUpWhiskCount\":0,\"innerLeftUpBrushTime\":2,\"innerLeftDownBrushCount\":0,\"innerLeftDownWhiskCount\":0,\"innerLeftDownBrushTime\":0,\"innerCenterUpBrushCount\":0,\"innerCenterUpWhiskCount\":0,\"innerCenterUpBrushTime\":0,\"innerCenterDownBrushCount\":0,\"innerCenterDownWhiskCount\":0,\"innerCenterDownBrushTime\":0,\"innerRightUpBrushCount\":2,\"innerRightUpWhiskCount\":0,\"innerRightUpBrushTime\":1,\"innerRightDownBrushCount\":0,\"innerRightDownWhiskCount\":0,\"innerRightDownBrushTime\":0,\"upLeftBrushCount\":11,\"upLeftBrushTime\":0,\"downLeftBrushCount\":7,\"downLeftBrushTime\":0,\"upRightBrushCount\":16,\"upRightBrushTime\":0,\"downRightBrushCount\":0,\"downRightBrushTime\":0}";
//			Map<String,Object> requestMap = new HashMap<String,Object>();
//			requestMap.put("data", data1);
//			HttpUtil.doPost("https://os.32teeth.cn/api/block/uploadRepeaterRecord",requestMap);
			
			
			List<String> dataList = new ArrayList<String>();
			for (int i = 0; i < 100; i++) {
				if (data.length() >= 148) {
					String macAddressData = data.substring(0, 148);
					data = data.substring(148, data.length());
					dataList.add(macAddressData);
				}
			}

			for (String dataStr : dataList) {
				List<RecordUploadDetailVo> recordUploadDetailVoList = new ArrayList<RecordUploadDetailVo>();
				RecordUploadDetailVo recordUploadDetailVo = handleRecordUploadDetailVo(dataStr);
				recordUploadDetailVoList.add(recordUploadDetailVo);
				Map<String,Object> requestMap = new HashMap<String,Object>();
				requestMap.put("data", JsonHelper.toJson(recordUploadDetailVoList));
				System.out.println(JsonHelper.toJson(recordUploadDetailVoList));
				HttpUtil.doPost("https://os.32teeth.cn/api/block/uploadRepeaterRecord",requestMap);
			}
			
			 ctx.write("Num data is OK.");
		}
	
    	
    
    }
 
    /**
     * 从客户端收到新的数据、读取完成时调用
     *
     * @param ctx
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws IOException
    {
    	System.out.println("channelReadComplete");
    	ctx.flush();
    }
 
    /**
     * 当出现 Throwable 对象才会被调用，即当 Netty 由于 IO 错误或者处理器在处理事件时抛出的异常时
     *
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws IOException
    {
    	System.out.println("exceptionCaught");
        cause.printStackTrace();
        ctx.close();//抛出异常，断开与客户端的连接
    }
 
    /**
     * 客户端与服务端第一次建立连接时 执行
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception, IOException
    {
        super.channelActive(ctx);
        ctx.channel().read();
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        //此处不能使用ctx.close()，否则客户端始终无法与服务端建立连接
        System.out.println("channelActive:"+clientIp+ctx.name());
    }
 
    /**
     * 客户端与服务端 断连时 执行
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception, IOException
    {
        super.channelInactive(ctx);
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        ctx.close(); //断开连接时，必须关闭，否则造成资源浪费，并发量很大情况下可能造成宕机
        System.out.println("channelInactive:"+clientIp);
    }
 
    /**
     * 服务端当read超时, 会调用这个方法
     *
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception, IOException
    {
        super.userEventTriggered(ctx, evt);
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        ctx.close();//超时时断开连接
    	System.out.println("userEventTriggered:"+clientIp);
    }
    
    
    /**
	 * 组装上传数据
	 * @param dataStr
	 * @return
	 */
	private static RecordUploadDetailVo handleRecordUploadDetailVo(String dataStr) {
		RecordUploadDetailVo recordUploadDetailVo = new RecordUploadDetailVo();
		String macAddress = dataStr.substring(0,12);
		String brushTeethTime = getBrushTime(dataStr);
		recordUploadDetailVo.setMacAddress(macAddress);
		recordUploadDetailVo.setBrushTeethTime(brushTeethTime);
		
		recordUploadDetailVo.setOutLeftUpXBrushCount(for16TurnTo10(dataStr.substring(26,28)));
		recordUploadDetailVo.setOutLeftUpYBrushCount(for16TurnTo10(dataStr.substring(28,30)));
		recordUploadDetailVo.setOutLeftUp45DegreeCount(for16TurnTo10(dataStr.substring(30,32)));
		recordUploadDetailVo.setOutLeftUpWhiskCount(for16TurnTo10(dataStr.substring(32,34)));
		recordUploadDetailVo.setOutLeftUpBrushTime(for16TurnTo10(dataStr.substring(34,36)));
		
		recordUploadDetailVo.setOutLeftDownXBrushCount(for16TurnTo10(dataStr.substring(36,38)));
		recordUploadDetailVo.setOutLeftDownYBrushCount(for16TurnTo10(dataStr.substring(38,40)));
		recordUploadDetailVo.setOutLeftDown45DegreeCount(for16TurnTo10(dataStr.substring(40,42)));
		recordUploadDetailVo.setOutLeftDownWhiskCount(for16TurnTo10(dataStr.substring(42,44)));
		recordUploadDetailVo.setOutLeftDownBrushTime(for16TurnTo10(dataStr.substring(44,46)));
		
		recordUploadDetailVo.setOutCenterUpXBrushCount(for16TurnTo10(dataStr.substring(46,48)));
		recordUploadDetailVo.setOutCenterUpYBrushCount(for16TurnTo10(dataStr.substring(48,50)));
		recordUploadDetailVo.setOutCenterUp45DegreeBrushCount(for16TurnTo10(dataStr.substring(50,52)));
		recordUploadDetailVo.setOutCenterUpWhiskCount(for16TurnTo10(dataStr.substring(52,54)));
		recordUploadDetailVo.setOutCenterUpBrushTime(for16TurnTo10(dataStr.substring(54,56)));
		
		recordUploadDetailVo.setOutCenterDownXBrushCount(for16TurnTo10(dataStr.substring(56,58)));
		recordUploadDetailVo.setOutCenterDownYBrushCount(for16TurnTo10(dataStr.substring(58,60)));
		recordUploadDetailVo.setOutCenterDown45DegreeBrushCount(for16TurnTo10(dataStr.substring(60,62)));
		recordUploadDetailVo.setOutCenterDownWhiskCount(for16TurnTo10(dataStr.substring(62,64)));
		recordUploadDetailVo.setOutCenterDownBrushTime(for16TurnTo10(dataStr.substring(64,66)));
		
		recordUploadDetailVo.setOutRightUpXBrushCount(for16TurnTo10(dataStr.substring(66,68)));
		recordUploadDetailVo.setOutRightUpYBrushCount(for16TurnTo10(dataStr.substring(68,70)));
		recordUploadDetailVo.setOutRightUp45DegreeBrushCount(for16TurnTo10(dataStr.substring(70,72)));
		recordUploadDetailVo.setOutRightUpWhiskCount(for16TurnTo10(dataStr.substring(72,74)));
		recordUploadDetailVo.setOutRightUpBrushTime(for16TurnTo10(dataStr.substring(74,76)));
		
		recordUploadDetailVo.setOutRightDownXBrushCount(for16TurnTo10(dataStr.substring(76,78)));
		recordUploadDetailVo.setOutRightDownYBrushCount(for16TurnTo10(dataStr.substring(78,80)));
		recordUploadDetailVo.setOutRightDown45DegreeBrushCount(for16TurnTo10(dataStr.substring(80,82)));
		recordUploadDetailVo.setOutRightDownWhiskCount(for16TurnTo10(dataStr.substring(82,84)));
		recordUploadDetailVo.setOutRightDownBrushTime(for16TurnTo10(dataStr.substring(84,86)));
		
		
		recordUploadDetailVo.setInnerLeftUpBrushCount(for16TurnTo10(dataStr.substring(86,88)));
		recordUploadDetailVo.setInnerLeftUpWhiskCount(for16TurnTo10(dataStr.substring(88,90)));
		recordUploadDetailVo.setInnerLeftUpBrushTime(for16TurnTo10(dataStr.substring(90,92)));
		
		recordUploadDetailVo.setInnerLeftDownBrushCount(for16TurnTo10(dataStr.substring(92,94)));
		recordUploadDetailVo.setInnerLeftDownWhiskCount(for16TurnTo10(dataStr.substring(94,96)));
		recordUploadDetailVo.setInnerLeftDownBrushTime(for16TurnTo10(dataStr.substring(96,98)));
		
		recordUploadDetailVo.setInnerCenterUpBrushCount(for16TurnTo10(dataStr.substring(98,100)));
		recordUploadDetailVo.setInnerCenterUpWhiskCount(for16TurnTo10(dataStr.substring(100,102)));
		recordUploadDetailVo.setInnerCenterUpBrushTime(for16TurnTo10(dataStr.substring(102,104)));
		
		recordUploadDetailVo.setInnerCenterDownBrushCount(for16TurnTo10(dataStr.substring(104,106)));
		recordUploadDetailVo.setInnerCenterDownWhiskCount(for16TurnTo10(dataStr.substring(106,108)));
		recordUploadDetailVo.setInnerCenterDownBrushTime(for16TurnTo10(dataStr.substring(108,110)));
		
		recordUploadDetailVo.setInnerRightUpBrushCount(for16TurnTo10(dataStr.substring(110,112)));
		recordUploadDetailVo.setInnerRightUpWhiskCount(for16TurnTo10(dataStr.substring(112,114)));
		recordUploadDetailVo.setInnerRightUpBrushTime(for16TurnTo10(dataStr.substring(114,116)));
		
		recordUploadDetailVo.setInnerRightDownBrushCount(for16TurnTo10(dataStr.substring(116,118)));
		recordUploadDetailVo.setInnerRightDownWhiskCount(for16TurnTo10(dataStr.substring(118,120)));
		recordUploadDetailVo.setInnerRightDownBrushTime(for16TurnTo10(dataStr.substring(120,122)));
		
		recordUploadDetailVo.setUpLeftBrushCount(for16TurnTo10(dataStr.substring(122,124)));
		recordUploadDetailVo.setUpLeftBrushTime(for16TurnTo10(dataStr.substring(124,126)));
		
		recordUploadDetailVo.setDownLeftBrushCount(for16TurnTo10(dataStr.substring(126,128)));
		recordUploadDetailVo.setDownLeftBrushTime(for16TurnTo10(dataStr.substring(128,130)));
		
		recordUploadDetailVo.setUpRightBrushCount(for16TurnTo10(dataStr.substring(130,132)));
		recordUploadDetailVo.setUpRightBrushTime(for16TurnTo10(dataStr.substring(132,134)));
		
		recordUploadDetailVo.setDownRightBrushCount(for16TurnTo10(dataStr.substring(134,136)));
		recordUploadDetailVo.setDownRightBrushTime(for16TurnTo10(dataStr.substring(136,138)));
		
		int brushTeethDuration = for16TurnTo10(dataStr.substring(138,140)) + for16TurnTo10(dataStr.substring(140,142));
		recordUploadDetailVo.setBrushTeethDuration(brushTeethDuration);
//		System.out.println(for16TurnTo10(dataStr.substring(138,140)));
//		System.out.println(for16TurnTo10(dataStr.substring(140,142)));
//		System.out.println(dataStr.substring(138,140));
//		System.out.println(dataStr.substring(140,142));
		return recordUploadDetailVo;
	}
	
	
	/**
	 * 获取时间
	 * @return
	 */
	public static String getBrushTime(String dataStr){
		String year = for16TurnTo10Add0(dataStr.substring(12,14))+for16TurnTo10(dataStr.substring(14,16));
		String month = for16TurnTo10Add0(dataStr.substring(16,18));
		String day = for16TurnTo10Add0(dataStr.substring(18,20));
		String hour = for16TurnTo10Add0(dataStr.substring(20,22));
		String minute = for16TurnTo10Add0(dataStr.substring(22,24));
		String second = for16TurnTo10Add0(dataStr.substring(24,26));
		return year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
	}
	
	/**
	 * 16进制转10进制
	 * @param str
	 * @return
	 */
	public static Integer for16TurnTo10(String str){
		return Integer.valueOf(new BigInteger(str, 16).toString(10));
	}
	
	public static String for16TurnTo10Add0(String str){
		String result = new BigInteger(str, 16).toString(10);
		if(result.length() == 1){
			result = "0"+result;
		}
		return result;
	}
}
