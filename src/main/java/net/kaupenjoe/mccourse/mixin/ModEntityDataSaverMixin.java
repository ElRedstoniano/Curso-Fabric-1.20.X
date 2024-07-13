package net.kaupenjoe.mccourse.mixin;

import net.kaupenjoe.mccourse.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class ModEntityDataSaverMixin implements IEntityDataSaver {
    private NbtCompound persistentData;

    @Override
    public NbtCompound getPersistentData() {
        if(this.persistentData == null){
            this.persistentData = new NbtCompound();
        }
//        System.out.println("TEST-O");
        return persistentData;
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> info){
        if(this.persistentData != null){
            nbt.put("mccourse.custom_data", persistentData);
            System.out.println(persistentData.asString() + "OK");
        } else{
//            getPersistentData(); // Needs to be called somewhere
//            nbt.put("mccourse.custom_data", persistentData);
//            System.out.println("TEST-1");
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info){
        if (nbt.contains("mccourse.custom_data", 10)) {
            this.persistentData = nbt.getCompound("mccourse.custom_data");
//            System.out.println(persistentData.asString() + "OK");
        }
    }
}
