JAVA_COMMAND = java -jar alexp/target/benchmark.jar
CONFIG_PATH = alexp/data/explanation/experiments/hics_mod_datasets/experiment2_a/beam_configs/synthmod100/iforest
OUTPUT_PATH = alexp/explanationExp/hics_datasets_modified/experiment2_a
BENCH_COMMAND = "$(JAVA_COMMAND) -b $(CONFIG_PATH) --e --so $(OUTPUT_PATH)"
all:
	tmux new -d -s mod_hics_data_exp2a_beam_100_iforest
	tmux send-keys -t mod_hics_data_exp2a_beam_100_iforest.0 "cd ~/Documents/macrobase" ENTER
	tmux send-keys -t mod_hics_data_exp2a_beam_100_iforest.0 $(BENCH_COMMAND) ENTER
