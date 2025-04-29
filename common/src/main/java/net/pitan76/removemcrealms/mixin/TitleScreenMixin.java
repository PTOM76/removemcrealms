package net.pitan76.removemcrealms.mixin;

import net.minecraft.client.gui.screens.TitleScreen;
import net.pitan76.removemcrealms.CommonClass;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

    @Inject(method = "createNormalMenuOptions", at = @At("HEAD"))
    private void createNormalMenuOptions(CallbackInfo info) {
        CommonClass.mixiningScreen = true;
    }

    @Inject(method = "createNormalMenuOptions", at = @At("RETURN"))
    private void createNormalMenuOptionsReturn(CallbackInfo info) {
        CommonClass.mixiningScreen = false;
    }
}
