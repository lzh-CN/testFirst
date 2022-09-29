package com.example.first.util;

import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;

import java.util.UUID;


public class VideoUtil {

    public static String videoPath_temp_path= "D://temp/";

    public static void main(String[] args) {
        mergeAV("D:\\lzh\\work\\zcybd\\trumpet\\zcybd-iot-trumpet\\vedio\\eqd56.mp3","D:\\lzh\\work\\zcybd\\trumpet\\zcybd-iot-trumpet\\vedio\\f1wah.mp3");
    }

    public static String mergeAV(String audioPath, String videoPath){
        String outputPath = videoPath_temp_path+UUID.randomUUID()+".mp3";
        try (FFmpegFrameGrabber imageGrabber = new FFmpegFrameGrabber(videoPath);
             FFmpegFrameGrabber audioGrabber = new FFmpegFrameGrabber(audioPath)) {
            imageGrabber.start();
            audioGrabber.start();
            try (FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(outputPath, imageGrabber.getImageWidth(), imageGrabber.getImageHeight(),
                    1);) {

                recorder.setInterleaved(true);
//                recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
                recorder.setFormat("mp3");
                recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P); // yuv420p
                int frameRate = 25;
                recorder.setFrameRate(frameRate);
                recorder.setGopSize(frameRate * 2);
                recorder.setAudioOption("crf", "0");
                recorder.setAudioQuality(0);// 最高质量
                recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);
                recorder.setAudioChannels(2);
                recorder.setSampleRate(44100);
                recorder.start();
                long videoTime = imageGrabber.getLengthInTime();
                Frame imageFrame = null;
                while ((imageFrame = imageGrabber.grabImage()) != null) {
                    recorder.record(imageFrame);
                }
                long audioPlayTime = 0L;
                Frame sampleFrame = null;
                while ((sampleFrame = audioGrabber.grabSamples()) != null || audioPlayTime < videoTime) {
                    if (sampleFrame == null) {
                        audioGrabber.restart();//重新开始
                        sampleFrame = audioGrabber.grabSamples();
                        videoTime -= audioPlayTime;
                    }
                    recorder.record(sampleFrame);
                    audioPlayTime = audioGrabber.getTimestamp();
                    if (audioPlayTime >= videoTime) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return outputPath;

    }


}
