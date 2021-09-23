JAVA_COMMAND = java -jar alexp/target/benchmark.jar
CONFIG_PATH = alexp/data/explanation/experiments/hics_mod_datasets/experiment1_a/lookout_configs/synthmod100/2D_B50
OUTPUT_PATH = alexp/explanationExp/hics_datasets_modified/experiment1_a
BENCH_COMMAND = "$(JAVA_COMMAND) -b $(CONFIG_PATH) --e --so $(OUTPUT_PATH)"
all:
	tmux new -d -s mod_hics_data_exp1a_lookout_100_2d
	tmux send-keys -t mod_hics_data_exp1a_lookout_100_2d.0 "cd ~/Documents/macrobase" ENTER
	tmux send-keys -t mod_hics_data_exp1a_lookout_100_2d.0 $(BENCH_COMMAND) ENTER
