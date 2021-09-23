function [yHat] = run_loda(dataset_name,winSize,trainSize,sparsity,histType,maxBins, op_file)
    dataset = csvread(dataset_name);
    X = dataset(:, 1:end-1);
    y = dataset(:, end);
    yHat = stream_loda_mod(X,y,winSize,trainSize,sparsity,histType,maxBins,op_file);
end