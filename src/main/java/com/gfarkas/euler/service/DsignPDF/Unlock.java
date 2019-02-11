package com.gfarkas.euler.service.DsignPDF;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Unlock {
    public Unlock() {
    }

    public static void unlock(File path) {
        try {
            FileOutputStream fout = new FileOutputStream(path);
            Throwable var2 = null;

            try {
                BufferedOutputStream bout = new BufferedOutputStream(fout);
                Throwable var4 = null;

                try {
                    PrintStream out = new PrintStream(bout);
                    Throwable var6 = null;

                    try {
                        out.print("This would normally not be written!");
                    } catch (Throwable var53) {
                        var6 = var53;
                        throw var53;
                    } finally {
                        if (out != null) {
                            if (var6 != null) {
                                try {
                                    out.close();
                                } catch (Throwable var52) {
                                    var6.addSuppressed(var52);
                                }
                            } else {
                                out.close();
                            }
                        }

                    }
                } catch (Throwable var55) {
                    var4 = var55;
                    throw var55;
                } finally {
                    if (bout != null) {
                        if (var4 != null) {
                            try {
                                bout.close();
                            } catch (Throwable var51) {
                                var4.addSuppressed(var51);
                            }
                        } else {
                            bout.close();
                        }
                    }

                }
            } catch (Throwable var57) {
                var2 = var57;
                throw var57;
            } finally {
                if (fout != null) {
                    if (var2 != null) {
                        try {
                            fout.close();
                        } catch (Throwable var50) {
                            var2.addSuppressed(var50);
                        }
                    } else {
                        fout.close();
                    }
                }

            }
        } catch (IOException var59) {
            var59.printStackTrace();
        }

    }
}
