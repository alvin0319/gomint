package io.gomint.server.command.vanilla;

import io.gomint.command.Command;
import io.gomint.command.CommandOutput;
import io.gomint.command.CommandSender;
import io.gomint.command.PlayerCommandSender;
import io.gomint.command.annotation.*;
import io.gomint.command.validator.EnumValidator;
import io.gomint.command.validator.IntegerValidator;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.world.Difficulty;
import java.util.Map;

/**
 * @author Clockw1seLrd
 * @version 1.0
 */
@Name("difficulty")
@Description("Sets the difficulty level.")
@Permission("gomint.command.difficulty")
@Overload({
    @Parameter(name = "difficulty", validator = EnumValidator.class, arguments = {"peaceful", "easy", "normal", "hard"})
})
@Overload({
    @Parameter(name = "difficulty", validator = IntegerValidator.class)
})
public class DifficultyCommand extends Command {

    @Override
    public CommandOutput execute(CommandSender<?> sender, String alias, Map<String, Object> arguments) {
        if (!(sender instanceof PlayerCommandSender)) {
            return CommandOutput.failure("Executor is required to be a player");
        }

        String difficultyDegree = String.valueOf(arguments.get("difficulty"));
        Difficulty difficulty;

        switch (difficultyDegree) {
            case "0":
            case "peaceful":
                difficulty = Difficulty.PEACEFUL;
                break;
            case "1":
            case "easy":
                difficulty = Difficulty.EASY;
                break;
            case "2":
            case "normal":
                difficulty = Difficulty.NORMAL;
                break;
            case "3":
            case "hard":
                difficulty = Difficulty.HARD;
                break;
            default:
                return CommandOutput.failure(String.format("No such difficulty degree: %s", difficultyDegree));
        }

        EntityPlayer executor = (EntityPlayer) sender;
        executor.world().difficulty(difficulty);

        return CommandOutput.successful(String.format("Set game difficulty to %s", difficulty.name()));
    }

}
