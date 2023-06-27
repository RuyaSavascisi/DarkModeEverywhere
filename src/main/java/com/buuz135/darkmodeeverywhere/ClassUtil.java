package com.buuz135.darkmodeeverywhere;

import com.mojang.blaze3d.systems.RenderSystem;
import cpw.mods.modlauncher.api.INameMappingService;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.util.stream.Stream;

public class ClassUtil {

    private static final String SET_SHADER_METHOD_NAME = ObfuscationReflectionHelper.remapName(INameMappingService.Domain.METHOD, "m_157427_");

    /*
    public static StackTraceElement getCallerCallerClassName() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        for (int i = 1; i<stElements.length; i++) {
            StackTraceElement ste = stElements[i];
            String className = ste.getClassName();
            if (!className.equals(GameRenderer.class.getName())
                    && !className.equals(ClassUtil.class.getName())
                    && !className.equals(RenderSystem.class.getName())
                    && className.indexOf("java.lang.Thread") != 0
                    && !ste.getMethodName().equals(SET_SHADER_METHOD_NAME)
                    && !className.equals(GuiGraphics.class.getName())) {
                return ste;
            }
        }
        return null;
    }
    */

    private static String walkForCallerClassName(Stream<StackWalker.StackFrame> stackFrameStream) {
        return stackFrameStream
                .filter(frame -> !(
                        frame.getClassName().equals(GameRenderer.class.getName())
                                || frame.getClassName().equals(ClassUtil.class.getName())
                                || frame.getClassName().equals(RenderSystem.class.getName())
                                || frame.getClassName().startsWith("java.lang.Thread")
                                || frame.getMethodName().equals(SET_SHADER_METHOD_NAME)
                                || frame.getClassName().equals(GuiGraphics.class.getName())
                ))
                .findFirst()
                .map(f -> f.getClassName() + ":" + f.getMethodName())
                .orElse(null);
    }

    public static String getCallerClassName() {
        return StackWalker.getInstance()
                .walk(ClassUtil::walkForCallerClassName);
    }
}
