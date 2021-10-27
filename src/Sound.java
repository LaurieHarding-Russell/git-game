package src;

import org.lwjgl.openal.*;

import javax.sound.sampled.AudioFormat;

import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.ALC10.alcCreateContext;
import static org.lwjgl.openal.ALC10.alcOpenDevice;
import java.nio.ByteBuffer;

public class Sound {
    long device;
    long context;
    int buffer;

    public Sound() {
        device = alcOpenDevice((java.lang.CharSequence)null);
        context = alcCreateContext(device,(int[])null);
        buffer = alGenBuffers();
        ALC10.alcMakeContextCurrent(context);
        ALCCapabilities alcCapabilities = ALC.createCapabilities(device);
        ALCapabilities alCapabilities = AL.createCapabilities(alcCapabilities);

        System.out.println("OpenALC10  : " + alcCapabilities.OpenALC10);
        System.out.println("OpenALC11  : " + alcCapabilities.OpenALC11);
        System.out.println("ALC_EXT_EFX: " + alcCapabilities.ALC_EXT_EFX);
    }

    public void playBackgroundSound(ByteBuffer audioBuffer, int alFormat, int sampleRate) {
        alBufferData(buffer, alFormat, audioBuffer, sampleRate);
        int source = alGenSources();
        alSourcei(source,AL_BUFFER,buffer);
        alSourcePlay(source);
    }

    public int getALFormat(AudioFormat format) {
        int alFormat = -1;
        if(format.getChannels() == 1){
            if(format.getSampleSizeInBits() == 8){
                alFormat = AL_FORMAT_MONO8;
            } else if(format.getSampleSizeInBits() == 16){
                alFormat = AL_FORMAT_MONO16;
             }
        } else if(format.getChannels() == 2) {
            if (format.getSampleSizeInBits() == 8) {
                alFormat = AL_FORMAT_STEREO8;
            } else if (format.getSampleSizeInBits() == 16) {
                alFormat = AL_FORMAT_STEREO16;
            }
        }
        return alFormat;
    }
}
