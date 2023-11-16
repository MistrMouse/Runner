package com.spaulding.tools.Runner.objects;

import java.util.List;

public record RunRecord(String[] command, List<String> results, List<String> errors, int exitValue) {
}
