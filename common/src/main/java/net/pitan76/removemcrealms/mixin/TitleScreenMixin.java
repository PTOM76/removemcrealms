package net.pitan76.removemcrealms.mixin;

import net.minecraft.client.gui.screens.TitleScreen;
import net.pitan76.removemcrealms.CommonClass;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

    @Inject(method = "createNormalMenuOptions", at = @At("HEAD"))
    private void createNormalMenuOptions(int y, int rowHeight, CallbackInfoReturnable<Integer> cir) {
        CommonClass.mixiningScreen = true;
    }

    @Inject(method = "createNormalMenuOptions", at = @At("RETURN"))
    private void createNormalMenuOptionsReturn(int y, int rowHeight, CallbackInfoReturnable<Integer> cir) {
        CommonClass.mixiningScreen = false;
    }
}
