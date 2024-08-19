# DarkModeEverywhere

Dark Mode Everywhere uses the built in 1.18 Minecraft shaders to transform any GUI texture into a Dark Mode. Thanks to the shaders it will work in any GUI in the game, it will also try to modify the text color so its not hard to read in dark mode. Please report any visual issues so I can fix it.

The mod currently provides with 3 dark modes to suit your needs that can be easily changed.

You can have the possibilty of adding new GUI shaders by modifying the "darkmodeeverywhereshaders.json" and using a Resource Loader mod or a Resource Pack.

# Shader Blacklist

#A list of strings that will prevent the dark shader to be used.
#Each string consists of the class and the method or any part of it to prevent the use of the dark shader.
#The dump will consist of a bunch of string with this style 'net.minecraftforge.client.gui.overlay.ForgeGui:renderHunger' (class:method), any part of that dump (like just using renderHunger) will prevent the hunger bar from using the dark shader.
METHOD_SHADER_BLACKLIST = ["mezz.jei.common.render.FluidTankRenderer:drawTextureWithMasking", "renderCrosshair", "net.minecraft.client.gui.screens.TitleScreen", "renderSky", "renderHotbar", "setupOverlayRenderState", "net.minecraftforge.client.gui.overlay.ForgeGui", "renderFood", "renderExperienceBar"]
#Enabling this config will dump every 5 seconds which classes & methods were used to render something in the screen and the dark shader was trying to be used
METHOD_SHADER_DUMP = false
