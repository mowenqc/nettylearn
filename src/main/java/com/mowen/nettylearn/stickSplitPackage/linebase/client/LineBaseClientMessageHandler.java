package com.mowen.nettylearn.stickSplitPackage.linebase.client;

import com.mowen.nettylearn.handler.MessageHandler;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;

/***
 * desc  : com.mowen.nettylearn.stickSplitPackage.linebase.client
 * author: mowen
 * create_time: 2019/5/30 9:49
 * project_name : mowen_parent
 */
@Sharable
public class LineBaseClientMessageHandler extends MessageHandler {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        String text = "深夜下班路上经过一间煎饼果子档，正好肚子饿，我想买一个当宵夜。\n"
            + "\n"
            + "档主是一名约有四十岁的中年大叔，一脸慈祥，他熟练的捞起面浆，在锅中展开，打上鸡蛋，抹匀之后，他对我说：这里还剩下两根火腿肠，都给你了，赠送的。\n"
            + "\n"
            + "还有一次中午，在一间隆江猪脚饭吃午饭，因去得晚，只有剩菜了。我没有点花菜，店员却把那仅剩的花菜干净利落的捞给我，说这是最后一份菜花了，都给我了，省得占位置。\n"
            + "\n"
            + "当看到自己的煎饼果子有双份的火腿肠时，当看到自己的菜盘里多了一份免费的菜肴时，心里总会升起一股暖意。\n"
            + "\n"
            + "(2)\n"
            + "\n"
            + "一个节假日，和朋友外出旅游，回得晚，回到出租房时已是凌晨一点十分。一走到楼下，我看见房东太太的房屋大厅的灯还亮着，昏黄色的灯光从玻璃窗透出来。这么晚了，是她还没睡吗?还是她特意留盏灯给晚归的人?\n"
            + "\n"
            + "住在这一栋楼的人，职业千差万别，工作时间各不相同。\n"
            + "\n"
            + "我找过机会和她闲聊过，“房东，你保养得这么好，晚上都是几点睡的呀?”\n"
            + "\n"
            + "“一般十一点准时入睡。”她说。\n"
            + "\n"
            + "“这么早?有天我凌晨回来，见到你大厅的灯还亮着。”\n"
            + "\n"
            + "她说，“哦，我专门留的，晚归的人，看到有盏灯亮着，会有归属感嘛。”\n"
            + "\n"
            + "在深夜，出租房里一盏未灭的灯，会带来无限的安全感和温馨。\n";
        ctx.writeAndFlush(Unpooled.copiedBuffer(text.getBytes()));
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello\n".getBytes()));
    }
}
